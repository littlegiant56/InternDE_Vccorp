public class Client {
    public static void main(String[] args) {
        FurnitureAbstractFactory plasticFactory = FurnitureFactory.getFactory(MaterialType.PLASTIC);
        Chair plasticChair = plasticFactory.createChair();
        Table plasticTable = plasticFactory.createTable();
        plasticChair.create();
        plasticTable.create();

        FurnitureAbstractFactory woodFactory = FurnitureFactory.getFactory(MaterialType.WOOD);
        Chair woodChair = woodFactory.createChair();
        Table woodTable = woodFactory.createTable();
        woodChair.create();
        woodTable.create();
    }
}
