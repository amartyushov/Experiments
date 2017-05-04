package io.mart.beans

/**
 * @author Aleksandr Martiushov
 */
class Eval {
    public static void main(String[] args) {
        def e = new Eval()
        e.immutableBookEval()
    }

    void bookEval(){
        def book = new Book()
        book.title = "title"
        println book.title
        assert book.title == 'title'
    }

    void immutableBookEval(){
        def gina = new ImmutableBook('gina book')
        def regina = new ImmutableBook(title:'gina book')

        assert gina.title == 'gina book'
        assert gina == regina

        try {
            gina.title = "Oops!"
            assert false, "should not reach here"
        } catch (ReadOnlyPropertyException expected) {
            println "Expected Error: '$expected.message'"
        }

    }
}
