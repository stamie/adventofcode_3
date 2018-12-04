/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrix;

import Matrix.Row;
import Matrix.Pixel;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author stampel
 */
public class Matrix {
    
    protected List<Row> Rows;
    protected long MoreClaimsCount;
    
    
    public Matrix() {
        
        this.Rows = new LinkedList();
        this.MoreClaimsCount = 0;
    
    }
    
    public Matrix(List<Row> rows) {
        
        this.Rows = new LinkedList();
        this.Rows = rows;
        this.setMoreClaimsCount();
        
    }

    
    public long getMoreClaimsCount() {
        this.setMoreClaimsCount();
        return this.MoreClaimsCount;
    }
    public void setMoreClaimsCount() {
        
        this.MoreClaimsCount = 0;
        for (Row row: this.Rows){
            this.MoreClaimsCount =+ row.getMoreClaimsCount();
        
        }
    }
    
    public boolean addRow(Row row) {
        
        int i = 0;
        for (Row r: this.Rows) {
            if (r.getRowNum() == row.getRowNum()) {
                return false;
            }
            if (r.getRowNum() > row.getRowNum()) {
                
                this.Rows.add(i, row);
                this.setMoreClaimsCount();
                return true;
            }
            i++;
        
        }
        this.Rows.add(row);
        
        this.setMoreClaimsCount();
        
        return true;
    
    }
    
    public void updateRow(Row row) {
        
        int i = 0;
        for (Row r: this.Rows) {
            if (r.getRowNum() == row.getRowNum()) {
                for (Pixel pixel: row.getPixels()){
                    r.addPixelToRow(pixel);
                }
                
                this.Rows.remove(i);
                this.Rows.add(r);
                this.setMoreClaimsCount();
                return;
            }
            i++;
        
        }
        
       
    }
    
    public List<Row> getRows() {
    
        return this.Rows;
    
    }
    
    
}
