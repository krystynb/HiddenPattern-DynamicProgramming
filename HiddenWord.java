
public class HiddenWord {
    

    private String w1, w2;

public HiddenWord(String word1, String word2) {

        w1 = word1;
        w2 = word2;
}

//create the matrix that calculates the num of common characters in relatively the same order 
public int[][] patternMatrix(){
    int m = w1.length();
    int n = w2.length();

    int[][] L = new int[m+1][n+1]; 

    for (int i = 0; i <= m; i++) {
        for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0)
            L [i][j] = 0;
        else if (w1.charAt(i-1) == w2.charAt(j-1))
            L [i][j] = L [i-1][j-1] + 1;
        else
            L [i][j] = Math.max(L[i-1][j], L [i][j-1]);
        }        
    }

    return L;
}

// generate the matrix showing which letters should be added to the pattern string 
public String[][] directionMatrix()
{
    int m = w1.length();
    int n = w2.length();

    int[][] L = patternMatrix();

    String match = "f";
    String[][] G = new String[m+1][n+1];

    for (int i = 0; i <= m; i++) {
        for (int j = 0; j <= n; j++) {

            if (i == 0 && j ==0)
                G[i][j] = "";
            else if (i == 0 || match == "t")
                G[i][j] = "L";
            else if (j == 0 )
                G[i][j] = "U";
            else if ((L[i][j] > L[i][j-1]) && (L[i][j] > L[i-1][j]))
                {
                    G[i][j] = "D";
                    match = "t";
                }     
            else 
                G [i][j] = "U";
        
        }   
        match = "f";
    }
    return G;
}


//traverse the direction matrix in reverse and return the pattern 
public String find(){
    int i = w1.length();
    int j = w2.length();
    String word = w2;

    if (i < j)
    {
        word = w1;
    }

    String pattern = "";

    String[][] F = directionMatrix();



    while (i > 0 && j > 0) {

        switch(F[i][j])
        {
        case "D":
            pattern = word.charAt(Math.min(i,j) - 1 ) + pattern;
            i -= 1;
            j -= 1;
            break;
        case "U":
            i -= 1;
            break;
        case "L":
            j -=1;
            break;
        }
    }
    return pattern;
}


//getters and setters
public String getW1() {
    return w1;
}


public void setW1(String w1) {
    this.w1 = w1;
}


public String getW2() {
    return w2;
}


public void setW2(String w2) {
    this.w2 = w2;
}



}
