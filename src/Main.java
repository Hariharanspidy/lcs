public class Main {
    public static void Lcs(String s1,String s2){
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<s1.length()+1;i++){
            for (int j=0;j<s2.length()+1;j++){
                if(i==0||j==0)
                    dp[i][j]=0;
                else if (s1.charAt(i-1)==(s2.charAt(j-1)))
                    dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        StringBuilder lcsString = new StringBuilder();
        int i = s1.length(), j = s2.length();
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1)==(s2.charAt(j-1))) {
                lcsString.append(s1.charAt(i-1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        // The LCS string is constructed backwards, so reverse it
        lcsString.reverse();
        System.out.println(lcsString);
        
    }
    public static void main(String[] args) {
        Lcs("AGGTAB","GXTXAYB");
    }
}