package org.example;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.*;

public class TopURLsAnalysis {
    public static void main(String[] args) {

        SparkSession spark = SparkSession.builder()
                .appName("Top URLs Analysis")
                .config("spark.ui.showConsoleProgress", "false")
                .getOrCreate();


        String pcFolderPath = "/data/Parquet/PageViewV1/*";
        spark.read().parquet(pcFolderPath).createOrReplaceTempView("pc_table");

        String mobileFolderPath = "/data/Parquet/PageViewMobile/*";
        spark.read().parquet(mobileFolderPath).createOrReplaceTempView("mb_table");

        String adnlogFolderPath = "/data/Parquet/AdnLog/*";
        spark.read().parquet(adnlogFolderPath).createOrReplaceTempView("adlog_table");

        Dataset<Row> topViewsPC = spark.sql("SELECT CONCAT(domain, path) AS url, COUNT(*) AS views FROM pc_table GROUP BY CONCAT(domain, path) ORDER BY views DESC LIMIT 10");

        Dataset<Row> topViewsMobile = spark.sql("SELECT CONCAT(domain, path) AS url, COUNT(*) AS views FROM mb_table GROUP BY CONCAT(domain, path) ORDER BY views DESC LIMIT 10");

        Dataset<Row> topViewsCombined = spark.sql("SELECT CONCAT(domain, path) AS url, COUNT(*) AS views FROM (   SELECT domain, path FROM pc_table   UNION ALL   SELECT domain, path FROM mb_table ) combined GROUP BY CONCAT(domain, path) ORDER BY views DESC LIMIT 10");

        Dataset<Row> topUsersPC = spark.sql("SELECT CONCAT(domain, path) AS url, COUNT(DISTINCT guid) AS unique_users FROM pc_table GROUP BY CONCAT(domain, path) ORDER BY unique_users DESC LIMIT 10");

        Dataset<Row> topUsersMobile = spark.sql("SELECT CONCAT(domain, path) AS url, COUNT(DISTINCT uid) AS unique_users FROM mb_table GROUP BY CONCAT(domain, path) ORDER BY unique_users DESC LIMIT 10");

        Dataset<Row> topUsersCombined = spark.sql("SELECT CONCAT(domain, path) AS url, COUNT(DISTINCT user_id) AS unique_users FROM (   SELECT domain, path, CAST(guid AS STRING) AS user_id FROM pc_table   UNION ALL   SELECT domain, path, guid AS user_id FROM mb_table ) combined GROUP BY CONCAT(domain, path) ORDER BY unique_users DESC LIMIT 10");

        Dataset<Row> viewCount = spark.sql("SELECT campaignId, COUNT(*) AS view_count FROM adlog_table WHERE click_or_view = false GROUP BY campaignId ORDER BY view_count DESC");

        Dataset<Row> clickCount = spark.sql("SELECT campaignId, COUNT(*) AS click_count FROM adlog_table WHERE click_or_view = true GROUP BY campaignId ORDER BY click_count DESC");

        Dataset<Row> num_view = spark.sql("SELECT num_view, COUNT(DISTINCT guid) AS user_count FROM (SELECT campaignId, guid, ROW_NUMBER() OVER (PARTITION BY campaignId, guid ORDER BY time_group.time_create) - 1 AS num_view FROM adlog_table WHERE click_or_view = true) AS clicks GROUP BY num_view ORDER BY num_view");

        topViewsPC.show(false);
        topViewsMobile.show(false);
        topViewsCombined.show(false);
        topUsersPC.show(false);
        topUsersMobile.show(false);
        topUsersCombined.show(false);
        viewCount.show(false);
        clickCount.show(false);
        num_view.show(30, false);

        spark.stop();
    }
}
