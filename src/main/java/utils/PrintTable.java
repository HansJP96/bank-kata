package utils;

import dnl.utils.text.table.TextTable;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;

public class PrintTable {
    private final String[] tableHeaders;
    private final List<HashMap<String, String>> rowData;
    private final int rowsNumber;
    private final int columnNumber;

    public PrintTable(String[] tableHeaders, List<HashMap<String, String>> rowData) {
        this.tableHeaders = tableHeaders;
        this.columnNumber = tableHeaders.length;
        this.rowData = rowData;
        this.rowsNumber = rowData.size();
    }

    public void showTable() {
        TextTable textTable = new TextTable(tableHeaders, transformRows());
        tableFormat(textTable);
        textTable.printTable();
    }

    private Object[][] transformRows() {
        int counter = 0;
        Object[][] printableData = new Object[rowsNumber][];
        for (HashMap<String, String> data : rowData) {
            printableData[counter] = transformRowColumns(data);
            counter++;
        }
        return printableData;
    }

    private Object[] transformRowColumns(HashMap<String, String> data) {
        Object[] arrayData = new Object[columnNumber];
        for (int i = 0; i < columnNumber; i++) {
            arrayData[i] = data.get(tableHeaders[i]);
        }
        return arrayData;
    }

    private void tableFormat(TextTable textTable) {
        textTable.setSort(0, SortOrder.DESCENDING);
    }
}
