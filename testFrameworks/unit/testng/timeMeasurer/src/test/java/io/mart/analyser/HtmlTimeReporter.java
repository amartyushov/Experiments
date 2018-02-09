package io.mart.analyser;

import htmlflow.HtmlView;
import htmlflow.elements.HtmlTable;
import htmlflow.elements.HtmlTr;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.util.Map;

public class HtmlTimeReporter extends AbstractTimeReporter {

    @Override
    public void report(Integer warnDuration, Integer warnCount) {
        HtmlView<?> taskView = new HtmlView<>();
        taskView
                .head()
                .title("Handler tests performance summary")
                .linkCss("https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css");

        createTable(taskView, testsExceededDuration(warnDuration), "Tests exceeded duration");
        createTable(taskView, hooksExceededDuration(warnDuration), "Hooks exceeded duration");

        createTable(taskView, testsExceededCount(warnCount), "Tests exceeded count");
        createTable(taskView, hooksExceededCount(warnCount), "Hooks exceeded count");

        try(PrintStream out = new PrintStream(new FileOutputStream("TaskTable.html"))){
            taskView.setPrintStream(out).write();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void createTable(HtmlView<?> view, Map<String, Info> map, String tableName) {
        HtmlTable<?> table = view.body()
                .classAttr("container")
                .heading(2, tableName)
                .div()
                .table().classAttr("table table-sm table-hover");

        HtmlTr<?> headerRow = table.tr();
        headerRow.th().text("Duration, ms");
        headerRow.th().text("Count");
        headerRow.th().text("Method");

        map.entrySet().stream()
                .forEach(entry -> {
                    HtmlTr<?> tr = table.tr();
                    tr.td().text(String.valueOf(entry.getValue().getDuration()));
                    tr.td().text(String.valueOf(entry.getValue().getCount()));
                    tr.td().text(entry.getKey());
                });
    }

}
