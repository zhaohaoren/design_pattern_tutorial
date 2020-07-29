package visitor;

public class ConcreteElementA implements Element {

    private String name;

    public ConcreteElementA(String name) {
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
