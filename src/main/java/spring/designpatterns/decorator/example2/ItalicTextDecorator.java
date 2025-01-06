package spring.designpatterns.decorator.example2;

public class ItalicTextDecorator extends TextDecorator{

    public ItalicTextDecorator(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String render(){
        return "<i>" + super.render() + "</i>";
    }
}
