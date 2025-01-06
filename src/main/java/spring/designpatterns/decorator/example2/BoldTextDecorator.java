package spring.designpatterns.decorator.example2;

public class BoldTextDecorator extends TextDecorator{

    public BoldTextDecorator(Text decoratedText){
        // inherit the initialization from parent abstract class
        super(decoratedText);
    }

    @Override
    public String render(){
        return "<b>" + super.render() + "<b>";
    }

}
