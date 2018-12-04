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
    protected long Y;
    
    
    Pixel(long id, long x, long y) {
        
        this.Id = id;
        this.X = x;
        this.Y = y;

    }
    Pixel(long x, long y) {
        
        this.Id = 0;
        this.X = x;
        this.Y = y;

    }
    
    public long getId() {
        
        return this.Id;
    
    }
    
    public long getX() {
        return this.X;
    }
    
    public long getY() {
        return this.Y;
    }
    
    public void setPixel(Pixel p) {

        if (this.getX() != p.getX() || this.getX() != p.getX()) {
            return;
        }
        if (this.getId() == 0) {
            this.Id = p.getId();
        } else if (this.getId() != p.getId()) {
            this.Id = -1;
        }
        return;
    }
    
            
    
    
}
