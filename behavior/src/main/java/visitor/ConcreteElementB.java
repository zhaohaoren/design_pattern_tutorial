package visitor;

public class ConcreteElementB implements Element {

    private String name;

    public ConcreteElementB(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }
}
