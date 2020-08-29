package programmers.kakao_previous.blind_2018;

import java.util.ArrayList;
import java.util.List;

public class FileNameSort {
    public static void main(String[] args) {
        String[] files = {"muzi00001"};
        String[] answer = solution(files);
    }

    public static String[] solution(String[] files) {


        List<FileInfo> fileInfoList = new ArrayList<>();
        for (String fileName : files) {
            FileInfo fileInfo = getFileInfo(fileName);
            fileInfoList.add(fileInfo);
        }

        fileInfoList.sort((o1, o2) -> {
            if (o1.getHead().toLowerCase().compareTo(o2.getHead().toLowerCase()) != 0) {
                return o1.getHead().toLowerCase().compareTo(o2.getHead().toLowerCase());
            } else { //파일명의 HEAD 부분이 같을 경우
                if (Integer.parseInt(o1.getNumber()) - Integer.parseInt(o2.getNumber()) != 0) {
                    return Integer.parseInt(o1.getNumber()) - Integer.parseInt(o2.getNumber());
                } else { //두 파일의 HEAD 부분과, NUMBER의 숫자도 같을 경우
                    return 0; //원래 입력에 주어진 순서를 유지한다.
                }
            }
        });

        String[] answer = new String[files.length];
        StringBuilder sb;
        for (int i = 0; i < answer.length; i++) {
            FileInfo fileInfo = fileInfoList.get(i);
            sb = new StringBuilder();
            sb.append(fileInfo.getHead()).append(fileInfo.getNumber()).append(fileInfo.getTail());
            answer[i] = sb.toString();
            System.out.print(answer[i] + " ");
        }

        return answer;
    }

    static FileInfo getFileInfo(String fileName) {
        String head = "", number = "", tail = "";

        int numStart = -1;
        // HEAD는 숫자가 아닌 문자로 이루어져 있으며, 최소한 한 글자 이상이다.
        for (int i = 0; i < fileName.length(); i++) {
            if (fileName.charAt(i) - '0' >= 0 && fileName.charAt(i) - '0' <= 9) {
                head = fileName.substring(0, i);
                numStart = i;
                break;
            }
        }


        int tailStart = -1;
        //NUMBER는 한 글자에서 최대 다섯 글자 사이의 연속된 숫자로 이루어져 있으며, 앞쪽에 0이 올 수 있다. 0부터 99999 사이의 숫자로, 00000이나 0101 등도 가능하다.
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = numStart; i <= numStart + 5; i++) {
            if (i >= fileName.length()) {   // 범위를 넘어가면 현재까지 만든 number set
                number = stringBuilder.toString();
                break;
            }
            if (fileName.charAt(i) - '0' >= 0 && fileName.charAt(i) - '0' <= 9) {   // 숫자일 경우만
                stringBuilder.append(fileName.charAt(i) - '0');
            } else {
                number = stringBuilder.toString();  // 숫자 끝
                tailStart = i;
                break;
            }
        }

        tail = (tailStart == -1) ? "" : fileName.substring(tailStart);

        return new FileInfo(head, number, tail);


    }

    static class FileInfo {
        String head, number, tail;

        public FileInfo(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        public String getHead() {
            return head;
        }

        public String getNumber() {
            return number;
        }

        public String getTail() {
            return tail;
        }

        @Override
        public String toString() {
            return "FileInfo{" +
                    "head='" + head + '\'' +
                    ", number='" + number + '\'' +
                    ", tail='" + tail + '\'' +
                    '}';
        }
    }
}
