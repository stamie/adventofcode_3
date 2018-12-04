/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrix;

/**
 *
 * @author stampel
 */
public class Pixel {
    
    protected long Id;
    protected long X;
    
    
    public Pixel(long id, long x) {
        
        this.Id = id;
        this.X = x;

    }
    public Pixel(long x) {
        
        this.Id = 0;
        this.X = x;

    }
    
    public long getId() {
        
        return this.Id;
    
    }
    
    public long getX() {
        return this.X;
    }
    
    
    public void setPixel(Pixel p) {

        if (!this.isThisPixel(p)) {
            return;
        }
        if (this.getId() == 0) {
            this.Id = p.getId();
        } else if (this.getId() != p.getId()) {
            this.Id = -1;
        }
        return;
    }
    
    public boolean isThisPixel(Pixel p) {
    
        if (this.getX() != p.getX() || this.getX() != p.getX()) {
            return false;
        }
        
        return true;
    
    }
    
    
            
    
    
}
