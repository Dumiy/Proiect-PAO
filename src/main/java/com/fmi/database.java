package com.fmi;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;



import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;



public class database {
    private List<account> accountList = new ArrayList<account>();
    private int key;
    public database(){
        try{
            readDatabase();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
    public void readDatabase()throws IOException {
        FileInputStream file = new FileInputStream( new File("C:/Users/ASDERTY/IdeaProjects/PAOOO/excel/INFO.xlsx"));
        Workbook workbook = new XSSFWorkbook("C:/Users/ASDERTY/IdeaProjects/PAOOO/excel/INFO.xlsx");
        Sheet sheet = workbook.getSheetAt(0);
        int j  = 0;
        for (Row row : sheet) {
            int i = 0 ;
            Map <Integer,String> acc = new HashMap<Integer,String>();
            Cell cell1 = row.getCell(0);
            Cell cell2 = row.getCell(1);
            Cell cell3 = row.getCell(2);
            Cell cell4 = row.getCell(3);
            Cell cell5 = row.getCell(4);
            if (cell1 != null && (cell1.getStringCellValue().contains("Nume") != true && cell1.getStringCellValue().length() > 1) ) {
                acc.put(0, cell1.getStringCellValue());
                i++;
            }
            if (cell2 != null && (cell2.getStringCellValue().contains("Prenume") != true  && cell2.getStringCellValue().length() > 1)) {
                acc.put(1, cell2.getStringCellValue());
                i++;
            }
            if (cell3 != null && (cell3.getStringCellValue().contains("Adresa email") != true  && cell3.getStringCellValue().length() > 1)) {
                acc.put(2, cell3.getStringCellValue());
                i++;
            }
            if (cell4 != null && (cell4.getStringCellValue().contains("Parola email") != true && cell4.getStringCellValue().length() > 1)) {
                acc.put(3, cell4.getStringCellValue());
                i++;
            }
            if (cell5 != null && (cell5.getStringCellValue().contains("Utilizator Moodle") != true &&  cell5.getStringCellValue().length() > 1 )) {
                acc.put(4, cell5.getStringCellValue());
                i++;
            }
            if( i == 5) {
                account Tempo = new account(acc.get(0), acc.get(1), acc.get(2), acc.get(3), acc.get(4), j);
                this.accountList.add(Tempo);
                j++;
                i = 0;
            }
            else i = 0;
        }

    }
    public void printingData(){
        Iterator <account> accountIterator = accountList.iterator();
        while(accountIterator.hasNext()){
            accountIterator.next().print();
        }

    }

}
