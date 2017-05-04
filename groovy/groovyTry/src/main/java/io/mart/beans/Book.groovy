package io.mart.beans

import com.sun.corba.se.spi.activation.RepositoryPackage.ServerDef

/**
 * @author Aleksandr Martiushov
 */
class Book {
    private String title

    // but still book.title will reffer to this method
    def getTitle(){
        println 'I am overring actually getter'
        return title
    }

    //getters and setters are automatically generated under the hood
}
