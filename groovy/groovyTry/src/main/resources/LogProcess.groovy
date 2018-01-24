globalCounter = 0

void grepFor(String search, String splitBy) {
    def Integer sum = 0;
    def Integer number = 0;

    new File("consoleText.txt")
            .text
            .findAll(search)
            .each { it ->
                //println it
                //println it.split("=========> ")[1]
                sum += it.split(splitBy)[1].toInteger()
                number++
    }
    println "WHAT: " + search + "; DURATION: " + sum + "; COUNT: " + number
    println()
}

def void printAll(){
    grepFor("stopAsynchronousExecutionEngine took: =========> (\\d+)", "=========> ")
    grepFor("recreateDefaultTenant took: =========> (\\d+)", "=========> ")
    grepFor("restoreDefaultLicense took: =========> (\\d+)", "=========> ")
    grepFor("doLoginOnce took: =========> (\\d+)", "=========> ")
    grepFor("doLogin took: =========> (\\d+)", "=========> ")
    grepFor("Login of the tenant has taken (\\d+)", "taken ")
    grepFor("getCurrentConfigValue took (\\d+)", "took ")
    grepFor("Creation of ApacheCommonsConnection took (\\d+)", "took ")
    grepFor("DB connection was created. Took (\\d+)", "Took ")
    grepFor("DBUnit was retrieving a tables schema. Took (\\d+)", "Took ")
    grepFor("cleanDumpFiles took: =========> (\\d+)", "=========> ")
    grepFor("cleanLoadDb took: =========> (\\d+)", "=========> ")
    grepFor("end loadDataMysql, took (\\d+)", "took ")
}

printAll()
