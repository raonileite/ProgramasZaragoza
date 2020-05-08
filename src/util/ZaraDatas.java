/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Raoni
 */
public class ZaraDatas {
    public java.sql.Date converterData (Date pData) throws ParseException{
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy/MM/dd");
        String dataString = formatarDate.format(pData);
        if (pData == null || pData.equals(""))
            return null;
        
        java.sql.Date date = null;
        try{
            DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            date = new java.sql.Date(((java.util.Date)formatter.parse(dataString)).getTime());
        }catch (ParseException e){
            throw e;
        }
        return date;
    }
            
}
