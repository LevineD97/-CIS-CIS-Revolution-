public class VisualizeDDR {
    public static void main(String[] args) {
        PennDraw.setCanvasSize(512, 750);
        mainMenu();
        
        while (true) {
            if (startGame()) {
                break;
            }
        }
        
        songScreen();
        
        while (true) {
            Song s = selectSong();
            if (s != null) {
                PennDraw.clear();
                DDR.runGame(s);
                break;
            }
        }
        
        endScreen();
        
    }
    
    public static void endScreen() {
        
        PennDraw.clear(PennDraw.BLACK);
        PennDraw.setPenColor(PennDraw.WHITE);
        PennDraw.text(0.5, 0.5, "Nice work!");
        String scoreString = Integer.toString(DDR.score);
        PennDraw.text(0.5, 0.65, scoreString);
    }
    
    public static void mainMenu() {
        
        PennDraw.picture(0.5, 0.5, "background.png");
        PennDraw.picture(0.5, 0.25, "spacebar.png");
        PennDraw.picture(0.5, 0.5, "CISCISRevolution.png");
    }
    
    public static void songScreen() {
       
        PennDraw.clear(PennDraw.BLACK);
        PennDraw.picture(0.5, 0.5, "SongSelect.png");
    }
    
    public static Song selectSong() {
        if (PennDraw.hasNextKeyTyped()) {
            char key = PennDraw.nextKeyTyped();
            
            if (key == '1') {
                Song selectedSong = new Song(Songs.DAFTPUNK);
                return selectedSong;
            }
            
            if (key == '2') {
                Song selectedSong = new Song(Songs.SANDSTORM);
                return selectedSong;
            }
            
            if (key == '3') {
                Song selectedSong = new Song(Songs.ZELDA);
                return selectedSong;
            }
        }
        
        return null;
    }
    
    public static boolean startGame() {
        if (PennDraw.hasNextKeyTyped()) {
            if (PennDraw.nextKeyTyped() == ' ') {
                return true;
            }
        }
        
        return false;
    }

}