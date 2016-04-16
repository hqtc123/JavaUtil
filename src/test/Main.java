package test;
import java.util.Scanner;

public class Main {
    public String ipTo8bitBinStr(String s1) {
        int a = Integer.parseInt(s1);
        String s = Integer.toBinaryString(a);
        if (s.length() < 8) {
            int len = s.length();
            for (int i = 0; i < 8 - len; i++) {
                s = "0" + s;
            }
        }
        return s;
    }

    public boolean matchMask(String ruleMaskIP, String strIP) {
        String[] maskArr = ruleMaskIP.split("/");
        String ruleIP = maskArr[0];
        if (ruleIP.equals(strIP)) {
            return true;
        }
        int index = Integer.parseInt(maskArr[1]);
        if (index == 0) {
            return false;
        }
        String[] ruleArr = ruleIP.split("\\.");
        String[] ipArr = strIP.split("\\.");
        if (index < 8) {
            return ipTo8bitBinStr(ruleArr[0]).substring(0, index).equals(ipTo8bitBinStr(ipArr[0].substring(0, index)));
        } else {
            if (!ruleArr[0].equals(ipArr[0])) {
                return false;
            }
            if (index < 16) {
                return ipTo8bitBinStr(ruleArr[1]).substring(0, index - 8).equals(ipTo8bitBinStr(ipArr[1]).substring(0, index - 8));
            } else {
                if (!ruleArr[1].equals(ipArr[1])) {
                    return false;
                }
                if (index < 24) {
                    return ipTo8bitBinStr(ruleArr[2]).substring(0, index - 16).equals(ipTo8bitBinStr(ipArr[2]).substring(0, index - 16));
                } else {
                    if (!ruleArr[2].equals(ipArr[2])) {
                        return false;
                    }
                    String s3 = ipTo8bitBinStr(ruleArr[3]);
                    return ipTo8bitBinStr(ruleArr[3]).substring(0, index - 24).equals(ipTo8bitBinStr(ipArr[3]).substring(0, index - 24));
                }
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String line1 = sc.nextLine();
            String[] arr = line1.split(" ");
            int ruleNum = Integer.parseInt(arr[0]);
            int requestNum = Integer.parseInt(arr[1]);
            String[] ruleArr = new String[ruleNum];
            for (int i = 0; i < ruleNum; i++) {
                ruleArr[i] = sc.nextLine();
            }

            for (int i = 0; i < requestNum; i++) {
                String reqIP = sc.nextLine();
                boolean matched = false;
                for (int j = 0; j < ruleArr.length; j++) {
                    String[] arr2 = ruleArr[j].split(" ");
                    String ruleContent = arr2[1];
                    if (reqIP.equals(ruleContent) || (ruleContent.contains("/") && main.matchMask(ruleContent, reqIP))) {
                        if ("allow".equals(arr2[0])) {
                            System.out.println("YES");
                        } else {
                            System.out.println("NO");
                        }
                        matched = true;
                        break;
                    }
                }
                if (!matched) {
                    System.out.println("YES");
                }
            }
        }
    }
}
