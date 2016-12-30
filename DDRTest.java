public class DDRTest {
    public static void main(String[] args) {
        PennDraw.setCanvasSize(512, 750);
        PennDraw.setPenRadius(0.25);
        double ONE_PIXEL = .006;
        double x = 0.375;
        double y1 = 1.0;
        
     
        PennDraw.enableAnimation(83);
        String up = "up_arrow.png";
        String down = "down_arrow.png";
        String left = "left_arrow.png";
        String right = "right_arrow.png";
        while(true) {
            PennDraw.clear();
            PennDraw.picture(0.125, 0.17, "left_arrowbackground.png", 125, 125);
            PennDraw.picture(0.375, 0.17, "down_arrowbackground.png", 125, 125);
            PennDraw.picture(0.625, 0.17, "up_arrowbackground.png", 125, 125);
            PennDraw.picture(0.875, 0.17, "right_arrowbackground.png", 125, 125);
            drawArrow(0.125, y1 + 0.1, left);
            drawArrow(0.375, y1 + 0.2, down);
            drawArrow(0.625, y1 + 0.3, up);
            double y4 = y1 + 0.4;
            drawArrow(0.875, y4, right);
            y1 -= ONE_PIXEL;
            // .17 checks for hit
            if (y4 < 0.0) {
                y1 = 1.0;
            }
            PennDraw.advance();
        }
    }
    
    public static void drawArrow(double x, double y, String filename) {
        PennDraw.picture(x, y, filename, 125, 125);
    }
}