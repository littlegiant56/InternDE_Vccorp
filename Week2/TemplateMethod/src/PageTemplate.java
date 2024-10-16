public abstract class PageTemplate {

    // Template method
    public final void showPage() {
        showHeader();
        showNavigation();
        showBody();
        showFooter();
    }

    public void showHeader() {
        System.out.println("Header of the page");
    }

    public void showNavigation() {
        System.out.println("Navigation menu");
    }

    public void showFooter() {
        System.out.println("Footer of the page");
    }

    // Abstract method to be implemented by subclasses
    public abstract void showBody();
}
