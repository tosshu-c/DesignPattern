package abstractfactory.factory;

public abstract class Factory {
    public abstract Link createLink(String caption, String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title);

    public static Factory getFactory(String classname) {
        Factory factory = null;
        try {
            factory = (Factory) Class.forName(classname).getDeclaredConstructor().newInstance();
            System.out.println(String.format("* %s 処理開始", factory.getClass().getSimpleName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }
}
