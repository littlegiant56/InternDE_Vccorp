public class FurnitureFactory {
    public static FurnitureAbstractFactory getFactory(MaterialType materialType) {
        switch (materialType) {
            case PLASTIC:
                return new PlasticFactory();
            case WOOD:
                return new WoodFactory();
            default:
                throw new IllegalArgumentException("Unknown material type.");
        }
    }
}
