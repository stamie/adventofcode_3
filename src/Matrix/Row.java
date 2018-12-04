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
    
    public Row(long rowNum) {
        this.Pixels = new LinkedList();
        this.RowNum = rowNum;
        this.MoreClaimsCount = 0;
    
    }
    
    public Row(long rowNum, LinkedList<Pixel> pixels) {
        this.Pixels = new LinkedList();
        this.Pixels = pixels;
        this.RowNum = rowNum; //this is y
        this.setMoreClaimsCount();
    
    }
    
    public void addPixelToRow(Pixel pixel) {
        
        
        int i = 0;
        
        if (this.Pixels.isEmpty()) {
            this.Pixels.add(pixel);
            this.setMoreClaimsCount();
            return;
        
        }
        
        for (Pixel p: this.Pixels) {
            if (p.getX() == pixel.getX()) {
                this.Pixels.remove(p);
                p.setPixel(pixel);
                this.Pixels.add(i, p);
                this.setMoreClaimsCount();
                return;
            }
            
            if (p.getX() > pixel.getX()) {
                this.Pixels.add(i, pixel);
                return;
            }
            i++;
        
        }
        this.Pixels.add(pixel);
    }
    
    public List<Pixel> getPixels() {
        return this.Pixels;
    }
    public long getRowNum() {
        return this.RowNum;
    }
    public long getMoreClaimsCount() {
        
        this.setMoreClaimsCount();
        return this.MoreClaimsCount;
    }
    
    public void setMoreClaimsCount(){
        
        long ret=0;
        
        for (Pixel pixel: this.Pixels) {
            if (pixel.getId() == -1) {
                ret++;
            }
        }

        this.MoreClaimsCount = ret;
    }
}
