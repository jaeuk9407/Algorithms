package study.simulation.P14891;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] wheel = new int[4][8];
    static int[] isValid; // 회전하는 방향 저장 (0: 이동 X, 1: 시계, -1: 시계 반대)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = Integer.parseInt(input[j]);
            }
        }

        int round = Integer.parseInt(br.readLine());

        for (int i = 0; i < round; i++) {
            String[] input = br.readLine().split(" ");
            isValid = new int[4];

            // 실제 바퀴 index: 입력 받은 바퀴 번호 -1
            int wheelNum = Integer.parseInt(input[0]) - 1;
            int dir = Integer.parseInt(input[1]);

            check(wheelNum, dir);
            rotate(isValid);
        }

        System.out.println(countScore());
    }

    static int countScore() {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int num = wheel[i][0];

            if (num == 1) {
            	// 2^i 가산
                sum += Math.pow(2, i);
            }
        }
        return sum;
    }

    // 재귀적으로 변동 바퀴 범위와 방향 설정
    static void check(int wheelNum, int dir) {
    	// 해당 바퀴의 방향 체크
        isValid[wheelNum] = dir;

        // 해당 바퀴의 왼쪽, 오른쪽 바퀴
        int prev = wheelNum - 1;
        int next = wheelNum + 1;

        // 해당 바퀴의 왼쪽 바퀴 
        if (prev >= 0 && isValid[prev] == 0) {
            // 왼쪽 바퀴 검사
            if (wheel[prev][2] != wheel[wheelNum][6]) {
                check(prev, dir * -1);
            }
        }

        if (next <= 3 && isValid[next] == 0) {
            //오른쪽 바퀴 검사
            if (wheel[next][6] != wheel[wheelNum][2]) {
                check(next, dir * -1);
            }
        }
    }

    // isValid에 저장된 방향으로 바퀴 회전
    static void rotate(int[] isValid) {
        for (int i = 0; i < 4; i++) {
        	// 현재 바퀴가 회전해야 할 바퀴이면 
            if (isValid[i] != 0) {
                int[] temp = new int[8];

                int idx;
                for (int j = 0; j < 8; j++) {
                    idx = j + isValid[i];

                    if (idx == -1) {
                        idx = 7;
                    } else if (idx == 8) {
                        idx = 0;
                    }

                    temp[idx] = wheel[i][j];
                }

                wheel[i] = temp;
            }
        }
    }
}