/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrix;

import Matrix.Row;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author stampel
 */
public class Matrix {
    
    protected List<Row> Rows;
    protected long MoreClaimsCount;
    
    
    Matrix() {
        
        this.Rows = new LinkedList();
        this.MoreClaimsCount = 0;
    
    }
    
    Matrix(List<Row> rows) {
        
        this.Rows = new LinkedList();
        this.Rows = rows;
        this.setMoreClaimsCount();
        
    }
    
    public void setMoreClaimsCount() {
    
        for (Row row: this.Rows){
            this.MoreClaimsCount+= row.getMoreClaimsCount();
        
        }
    }
    
    public void addRow(Row row) {
        
        int i = 0;
        for (Row r: this.Rows) {
            if (r.getRowNum() == row.getRowNum()) {
                return;
            }
            if (r.getRowNum() < row.getRowNum()) {
                
                this.Rows.add(i, r);
                return;
            }
            i++;
        
        }
    
    }
    
    
}
