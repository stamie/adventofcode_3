/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrix;

import Matrix.Pixel;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author stampel
 */
public class Row {
    
    protected List<Pixel> Pixels;
    protected long RowNum;
    protected long MoreClaimsCount;
    
    Row(long rowNum) {
        this.Pixels = new LinkedList();
        this.RowNum = rowNum;
        this.MoreClaimsCount = 0;
    
    }
    
    Row(long rowNum, LinkedList<Pixel> pixels) {
        this.Pixels = new LinkedList();
        this.Pixels = pixels;
        this.RowNum = rowNum;
        this.MoreClaimsCount = this.setMoreClaimsCount();
    
    }
    
    public List<Pixel> getPixels() {
        return this.Pixels;
    }
    public long getRowNum() {
        return this.RowNum;
    }
    public long getMoreClaimsCount() {
        return this.MoreClaimsCount;
    }
    
    private long setMoreClaimsCount(){
        
        long ret=0;
        
        for (Pixel pixel: this.Pixels) {
            if (pixel.getId()==-1) {
                ret++;
            }
        }

        return ret;
    }
}
