package io.mart

/**
 * @author Aleksandr Martiushov
 */
class FileOperations {

    public static void main(String[] args) {
        FileOperations o = new FileOperations();
        print System.getProperty("user.dir");

    }

    void readByLine(){
        new File("src/main/resources/Example.txt").eachLine {
            line -> println "line : $line"
        }
    }

    void entireString(){
        File f = new File("src/main/resources/Example.txt")
        println f.text
    }

    void writeToFile(){
        new File("src/main/resources/Example.txt").withWriter("utf-8") {
            writer -> writer.writeLine 'Hello world'
        }
    }

    void fileSize(){
        File f = new File("src/main/resources/Example.txt")
        println "File ${f.absolutePath} has ${f.length()} bytes"
    }

    void isFile(){
        File f = new File("src")
        println "File? ${f.isFile()}"
        println "Dir? ${f.isDirectory()}"
    }

    void createDir(){
        def dir = new File("src/bla")
        dir.mkdir()
    }

    void deleteFile(){
        def f = new File("src/main/resources/Example1.txt")
        f.delete()
    }

    void copyFile(){
        def src = new File("src/main/resources/Example.txt")
        def dest = new File("src/main/resources/Example1.txt")
        dest << src.text
    }

    void dirRoot(){
        def rootFiles = new File("src/main").listRoots()
        rootFiles.each {
            file -> println file.absolutePath
        }
    }

    void eachFile(){
        def rootFiles = new File("src/main").eachFile {
            file -> println file.absolutePath
        }
    }

    void eachFileRecurse(){
        def rootFiles = new File("src/main").eachFileRecurse {
            file -> println file.absolutePath
        }
    }
}
