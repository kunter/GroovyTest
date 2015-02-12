package org.groovy.hakb

/**
 * Created by root on 12.02.15.
 */
class Foo {

    final String name = "John"

    private Integer amount;

    protected void setAmount(Integer amount) {
        this.amount = amount
    }
    def  cheese

    static void main (args){

        def foo=new Foo(cheese: "assa",amount: 15)
        foo.amount=10
        println(foo.toString())
        def xml=new groovy.util.NodeBuilder()
        xml.customers(){
            loc='London'
            sql.eachRow
        }


    }


    @Override
    public String toString() {
        return "Foo{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", cheese=" + cheese +
                '}';
    }
}
