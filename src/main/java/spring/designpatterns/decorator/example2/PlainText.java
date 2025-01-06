package spring.designpatterns.decorator.example2;

public class PlainText implements Text{

    private String content;

    public PlainText(String content){
        this.content = content;
    }

    @Override
    public String render() {
        return this.content;
    }
}
