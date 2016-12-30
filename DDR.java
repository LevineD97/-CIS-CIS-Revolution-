public class DDR {
    public static int frameCount = 0;
    public static int framesUntilNext = 0;
    public static int score;
    public static LinkedList<Arrow> arrows = new LinkedList<Arrow>();
    public static double ONE_PIXEL = 0.01;
    public static boolean firstTime = true;
    public static boolean isFileEmpty = false;
    public static String noteFilename;
    public static String imageFile;
    public static int timeUntilFirstNote;
    
    
    
    public static void descendArrows() {
        for (int i = 0; i < arrows.size(); i++) {
            Arrow thisArrow = arrows.get(i);
            thisArrow.decrementY();
        }
    }
    
    public static void drawArrows() {
        for (int i = 0; i < arrows.size(); i++) {
            Arrow thisArrow = arrows.get(i);
            thisArrow.draw(thisArrow.getY());
        }
    }
    
    public static void drawBackground() {
        PennDraw.clear();
        PennDraw.picture(0.5, 0.5, imageFile);
        PennDraw.picture(0.125, 0.17, "left_arrowbackground.png", 125, 125);
        PennDraw.picture(0.375, 0.17, "down_arrowbackground.png", 125, 125);
        PennDraw.picture(0.625, 0.17, "up_arrowbackground.png", 125, 125);
        PennDraw.picture(0.875, 0.17, "right_arrowbackground.png", 125, 125);
    }
    
    public static Arrow arrowFromString(String s) {
        if (s.equals("up")) {
            Arrow a = new Arrow(Direction.UP);
            return a;
        }
        
        if (s.equals("down")) {
            Arrow a = new Arrow(Direction.DOWN);
            return a;
        }
        
        if (s.equals("left")) {
            Arrow a = new Arrow(Direction.LEFT);
            return a;
        }
        
        if (s.equals("right")) {
            Arrow a = new Arrow(Direction.RIGHT);
            return a;
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        Song s = new Song (Songs.ZELDA);
        runGame(s);
    }
    
    public static void runGame(Song s) {
        PennDraw.enableAnimation(50);
        imageFile = s.imageFile;
        In inStream = new In(s.noteFile);
        
        s.playback();
        timeUntilFirstNote = inStream.readInt();
        while (true) {
            if ((frameCount < timeUntilFirstNote) && firstTime) {
                frameCount++;
                drawBackground();
                displayScore();
                
                PennDraw.advance();
                continue;
            }
            if (firstTime && timeUntilFirstNote == 0) {
                frameCount = 0;
            }
            timeUntilFirstNote = 0;
            if (isFileEmpty == false) {
                if (frameCount == framesUntilNext) {
                    
                    frameCount = 0;

                    framesUntilNext = inStream.readInt();

                    if (framesUntilNext == 0 && !firstTime) {
                        isFileEmpty = true;
                        continue;
                    }
                    
                    firstTime = false;
                    
                    String nextArrow = inStream.readString();
                    arrows.add(arrowFromString(nextArrow));
                }
            }
            
            if (arrows.isEmpty()) {
                frameCount++;
                continue;
            }
            
            drawBackground();
            displayScore();
            drawArrows();
            descendArrows();
            
            if (arrows.get(0).getY() < 0.13 && !arrows.isEmpty()) {
                arrows.remove(0);
            }

            if (checkForInput() && !arrows.isEmpty()) {
                if(checkStep(getInput())) {
                    incrementScore();
                    arrows.remove(0);
                }
            }
            
            
            
            frameCount++;
            
            if (arrows.isEmpty() && !firstTime && framesUntilNext == 0) {
                PennDraw.disableAnimation(); 
                return;
            }
            
            PennDraw.advance();
            
            
        }
    }

    
    public static char getInput() {
        return PennDraw.nextKeyTyped();
    }
    
    public static boolean checkForInput() {
        if (PennDraw.hasNextKeyTyped()) {
            return true;
        }
        
        return false;
    }
    
    public static boolean checkStep(char c) {
        Arrow closest = arrows.get(0);
        double x = closest.getX();
        double y = closest.getY();
        
        if (c == 'a') {
            if (x != 0.125) {
                return false;
            }
            
            if (y > 0.22 || y < 0.12) {
                return false;
            }
            
            return true;
        }
        
        if (c == 's') {
            if (x != 0.375) {
                return false;
            }
            
            if (y > 0.22 || y < 0.12) {
                return false;
            }
            
            return true;
        }
        
        if (c == 'w') {
            if (x != 0.625) {
                return false;
            }
            
            if (y > 0.22 || y < 0.12) {
                return false;
            }
            
            return true;
        }
        
        if (c == 'd') {
            if (x != 0.875) {
                return false;
            }
            
            if (y > 0.22 || y < 0.12) {
                return false;
            }
            
            return true;
        }
        
        return false;
    }
    
    public static void incrementScore() {
        score++;
    }
    
    public static void displayScore() {
        String scoreString = Integer.toString(score);
        PennDraw.text(0.9, 0.9, scoreString);
    }
    
    public int getScore() {
        return score;
    }
}