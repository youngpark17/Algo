# 백준+이외 프로그래머스 등등 문제 푼거 정리
![](https://i.imgur.com/XXXUt41.jpg)
![](https://i.imgur.com/esVpcLO.jpg)


## 모든 문제는 자바로 풀이

[백준 2517 달리기](https://github.com/youngpark17/Algorithm/commit/e02fd4d765d256ce9389ced895b864408c3c4ada)
nlogn 펜윅트리+압축 수가 많을 경우에는 sort보다 parallelSort가 빠름.

[백준 2842 집배원 한상덕 플레5](https://github.com/youngpark17/Algorithm/commit/e02fd4d765d256ce9389ced895b864408c3c4ada)
투포인터 +dfs, O(N^3)

[백준 11003 최솟값 찾기 플레5](https://github.com/youngpark17/Algorithm/commit/52e7215189a60252ed578c0b017e132fdd2d587c)
슬라이딩 윈도우 + 데큐 O(n)

[백준 2589 보물섬 골드5](https://github.com/youngpark17/Algorithm/commit/6744a7048101444dd680067e4f9de2522b580b56)
bfs

[백준 4179 불! 골드3](https://github.com/youngpark17/Algorithm/commit/666ca201c7b7446a1318eec9e33631d77ce9e4da)
bfs

[백준 6549 히스토그램에서 가장 큰 사각형 골드1](https://github.com/youngpark17/Algorithm/commit/e7b3e03af9b34abee4ff64ed47740ceee982083d)
O(nlogn)
세그먼트 트리 + 분할정복 오버플로 조심하자..

[백준 6416 트리인가? 골드5](https://github.com/youngpark17/Algorithm/commit/61165b128ed2cbd563ec8355145357bbc39f8ad7)
트리 판별 dfs, or indegree edge 수 가지고도 가능할듯.

[백준 2096 내려가기 골드4](https://github.com/youngpark17/Algorithm/commit/f92856053fe92da2d380f253dfb8d80385baaed2)
슬라이딩 윈도우 dp

[백준 11505 구간 곱 구하기 플레5](https://github.com/youngpark17/Algorithm/commit/4b98ec27b3fdb5179c21dea83df6fd992d8e39d4)
세그트리

[백준 11812 K진트리 골드3](https://github.com/youngpark17/Algorithm/commit/1c550bea1a8939cebc8ef866d34e3f5796199a09)
완전 K진트리의 부모노드는 자식을 node라 했을때 root가 1일때
 (node - 2)/k + 1, k가 1일때 예외처리

[백준 1647 도시 분할 계획 골드4](https://github.com/youngpark17/Algorithm/commit/13b2acf0c8f594b82ab5d157bfc56e70bf4b130b)
MST

[백준 5676 음주 코딩 플레5](https://github.com/youngpark17/Algorithm/commit/8278c7fd60816a59d5160b5ebe95810c17804d82)
부호 저장해서 푸는 세그먼트 펜윅ㅌ리 펜윅트리 풀이


[백준 4991 로봇청소기 ](https://github.com/youngpark17/Algorithm/commit/be80eefa3dc3224dc021631554e52c94fb13887d)

bfs로 최단경로 테이블 만들고 dfs  순열을 통해 청소기부터 시작하는 것중 최단경로구하자.

[백준 1197 최소 스패닝 트리 골드4](https://github.com/youngpark17/Algorithm/commit/01f9e6c3d789c7fa82f6f05dc08d6e1709e9cb7c)
mst

[백준 1103 게임 골드1](https://github.com/youngpark17/Algorithm/commit/8079c01531fc748bcd5cd41cdf578b4f10246afc)
dfs + dp

[백준 1039 교환 골드3](https://github.com/youngpark17/Algorithm/commit/2940b8a6325fd4298aca19a9b9329d44d4754507)
bfs, dfs 메모제이션

[백준 1516 게임 개발 골드3](https://github.com/youngpark17/Algorithm/commit/1972598b73d74b59b0b248aaf6b5e708e90f6ab7)
위상 정렬

[백준 1987 알파벳 골드4](https://github.com/youngpark17/Algorithm/commit/23844087590f3732097898d116fe7c58d5b1d63e)
문제 잘 읽자... dfs

[백준 11559 Puyo Puyo 골드5](https://github.com/youngpark17/Algorithm/commit/0a1f0d6344e0a1d0d53ce3c4fb5657728dec06d2)
완탐+구현

[백준 16968 인싸들의 가위바위보 골드3](https://github.com/youngpark17/Algorithm/commit/335e44814708296c0168f1a9ed019e64d28bd23c)
완탐+구현


[백준 16988 Baaaaaaaaaduk2(Easy) 골드3](https://github.com/youngpark17/Algorithm/commit/e859a3e220eecab09650fa2687a9fac013245533)
조합 + bfs + 구현

[백준 16985 Maaaaaaaaaze 골드3](https://github.com/youngpark17/Algorithm/commit/e6b19c0d8aabd2ab1dfe7d51248b8d21d8ce132b)
순열 + bfs + 구현

[백준 2188 열혈강호2 플레4](https://github.com/youngpark17/Algorithm/commit/1dbb8d4f29684b70487f36f0a6be6b8859e89389)
이분매칭 최대 유량 dfs이용 O(v*e)

[백준 2188 축사배정 플레4](https://github.com/youngpark17/Algorithm/commit/2f359cec949269693d0a38692c4892a77623b8ab)
이분매칭 최대 유량 dfs이용 O(v*e)


[백준 11375 열혈강호 플레4](https://github.com/youngpark17/Algorithm/commit/c059aaa9bac4468f04c881f3f1fc54836018d16e)
이분매칭 네트워크 플로우 dfs이용 O(v*e)

[백준 17779 게리멘더링2 골드4](https://github.com/youngpark17/Algorithm/commit/9b5fb5e139871fa0a555656c8c2cdf6d77402be1)
완탐, 구현 

[백준 11438 LCA2 플레5](https://github.com/youngpark17/Algorithm/commit/ac494b3dde7165a72f78a58361e27efdc59ffbfe)
LCA O(m*logn) 2^i만큼의 부모를 저장해놓자.
parents[i][j] = parents[parents[i][j-1]][j-1]
node i의 2^j번째 부모 업데이트는 node i의 2^j-1번째 부모에서 다시 2^j-1번째 만큼 더 가면된다.
node가 최악의 경우 일렬로 7개만큼 있다면 2^i번째 부모를 담는 배열의 크기는 1번째 2번째 4번째까지만 구하면 충분.
k = Math.ceil(Math.logn/Math.log2)

[백준 17837 새로운 게임2 골드2](https://github.com/youngpark17/Algorithm/commit/9b59f5a04da1d6811518c8bb13560490ba933a62)
...나의 하루를 너에게 바쳤다.  시뮬레이션 구현

[백준 18809 Gaaaaaaaaaaarden 골드1](https://github.com/youngpark17/Algorithm/commit/b0ffc1f509edba8cf8c513e1b8b231bad0f95d2d)

시뮬+dfs+bfs


[백준 17825 주사위 윷놀이 골드2](https://github.com/youngpark17/Algo/commit/d14eb760ffe634b33ce7c72a4730465bda01cad0)
중복순열 + 시뮬, 괄호를 쓰자.


[백준 14890 경사로 골드4](https://github.com/youngpark17/Algo/commit/3f968cca6ab3c41c048265d98a78683d438bfb49)
시뮬 O(n^2)

[백준 15685 드래곤커브  골드4](https://github.com/youngpark17/Algo/commit/23fd707a2e541898d337e09a95745f8638032f30)
시뮬 O(n^2)

[백준 2580 스도쿠  골드4](https://github.com/youngpark17/Algo/commit/821a69714ce14dca3c2c538bbee021aae8871bea)
백트래킹 O(n^n)
[백준 17626 Four Squares  실버5](https://github.com/youngpark17/Algo/commit/4434c7cccd40ac68f697df88f1a0802e7d1da4cc)
O(n^2) dp

[백준 1699 제곱수의 합  실버3](https://github.com/youngpark17/Algo/commit/5bf2ef8cabcbc5c1ee2130a5ea4dbfed7227e29d)
O(n^2) dp
[백준 2061 좋은 암호 브론즈3](https://github.com/youngpark17/Algo/commit/0e27fc82896fc4f2269c887d556239220a69b60d)
O(n^2)
에라토스테네스의 체 i*i하면 overflow날 수도 있다.
큰 수 나누어 떨어지는 지 확인 방법.

[백준 14288 내리 갈굼4 플레3](https://github.com/youngpark17/Algo/commit/ff79cc5d527cf1acf47034040c047b7ab2a16b3b)
펜윅트리 + dfs 트리번호 메기기 O(n+mlogn)

[백준 14287 내리갈굼3 플레 4](https://github.com/youngpark17/Algo/commit/f5671ac4ccd520b01e005010e00db8830ecc357a)
전위순회로 트리 만들기 + 펜윅트리 O(n+mlogn)

[백준 14268 내리갈굼2 플레3](https://github.com/youngpark17/Algo/commit/764d8a08fd1520b8a9c6dc8423409603c2a51175)

펜윅 트리 + dfs를 이용한 트리 부모자식 체크

[백준 1715 카드 정렬하기 골드4](https://github.com/youngpark17/Algo/commit/c04aaf4841dce3490cdef696b11001f381c453d0)
기초문제

[백준 17143 낚시왕 골드3](https://github.com/youngpark17/Algo/commit/b8ae8f52a50c163d7d54c9838405443772ebd21b)
낚시왕... 디버깅....


[백준 11660 구간합 구하기 3 플레5](https://github.com/youngpark17/Algo/commit/d24b57300ba07592f109afbf68a193b640fdd444)

prefixSum으로 풀었다. 펜윅 트리로 다시 풀어봐야할듯... 시간이..


[백준 10999 구간합 구하기 2 플레4](https://github.com/youngpark17/Algo/commit/012cb11120f16328a5669bb059d26d41b2e59730)

세그먼트 트리 with lazy propagation

[백준 18463 수열과 쿼리 37 플레5](https://github.com/youngpark17/Algo/commit/012cb11120f16328a5669bb059d26d41b2e59730)
세그먼트 트리

[백준 10868 최솟값 플레5](https://github.com/youngpark17/Algo/commit/9035365f2df4f7223ec4146da9ee808dcc1925e5)
세그먼트 트리

[백준 16975 수열과 쿼리 21 플레4](https://github.com/youngpark17/Algo/commit/16b5f4494da47ce153efd04ca1bf542e35a804a7)
세그먼트 트리 with lazy propagation

[백준 13544 수열과 쿼리3 플레3](https://github.com/youngpark17/Algo/commit/23ecb3c99cd3be0bbf25e77e6277fdc890170205)
세그먼트 트리+바이너리 서치 + 머지소트

[백준 2357 최소값 최대값 플레5](https://github.com/youngpark17/Algo/commit/447c56c017588a934d0f155b9010e78bc32aaf91)
세그먼트 트리

[백준 14438 수열과 쿼리 17 플레5](https://github.com/youngpark17/Algo/commit/71c4f9042ecc4b80fa70fae78ee700dcf8dc9556)
최소값 구하는 세그먼트 트리

[백준 14427 수열과 쿼리 16 플레5](https://github.com/youngpark17/Algo/commit/eacb5639f7dc3fcad9fdd6486a0a8423f12ae310)
14427에 구간에 대한 처리 추가


[백준 13537 수열과 쿼리 1 플레4](https://github.com/youngpark17/Algo/commit/4956c6dac5a5fbea57c08caf272911bf9499c3c5)
머지소트트리

[백준 14427 수열과 쿼리 15 골드1](https://github.com/youngpark17/Algo/commit/e184dcfb7329934473b25611e9bd3bc192e2fb32)
세그먼트 트리
구간에 대한 최소값의 인덱스.

[백준 12101 1,2,3 더하기 3 실버2](https://github.com/youngpark17/Algo/commit/b087178f24b0ebdc95f6d714c41d9eced607362d)

dp[i] = dp[i-1]+dp[i-2]+dp[i-3]

[백준 12101 1,2,3 더하기 2 실버](https://github.com/youngpark17/Algo/commit/04a7bb4c034125c52155f4711e012699ed99c30b)

[백준 12101 1,2,3 더하기 2 실버1]

String.split()은 인자로 정규표현식을 받고, 따라서 .으로 나눌경우 \\.를 인자로 넣어야한다.
StringTokenizer는 문자를 하나씩 쪼갠다.

[백준 17478 재귀함수가 뭔가요 실버5](https://github.com/youngpark17/Algo/commit/56b97419f5171e368c39bf68d0636d8c605f31b9)
"\ 로 따옴표 쓰기

[백준 14267 내리 갈굼 골드 4](https://github.com/youngpark17/Algo/commit/ceb4e78de51d63aa1cf38e65f530e0a460992701)
dfs, 매 쿼리에 대해서 돌리지말고 배열에 누적해놓고 한번에 처리.

[백준 9205 맥주마시면서 걸어가기 골드4](https://github.com/youngpark17/Algo/commit/6389c3851df803030c3b8aa331971dbf04f5d2d1)
bfs

[백준 2573 빙산 골드4](https://github.com/youngpark17/Algo/commit/2d1b2e0f7b1e62ec0cc7a8ec0d16172c35093f35)
dfs,bfs,시뮬

[백준 2468 안전영역 실버1](https://github.com/youngpark17/Algo/commit/0446b17d8effd950ea8ff33a460583b4f09848fd)
힐링문제

[백준 5014 스타트와 링크 골드5](https://github.com/youngpark17/Algo/commit/17d9ea50f1250558c55b6659924546956bd170d3)
힐링문제


[백준 2606 숨바꼭질 실버1](https://github.com/youngpark17/Algo/commit/d83e27b3405ae7e2a330dd8a260b0c718eb1ee0b)
힐링문제


[백준 2644 촌수계산 실버2](https://github.com/youngpark17/Algo/commit/950beaa1320d2b9ff52ab573a20784d4a71a8c25)
힐링문제

[백준 2606 바이러스 실버2](https://github.com/youngpark17/Algo/commit/b048692114af6fd06205d9ad862a0d4050d07414)
힐링문제

[백준 18808 스티커붙이기 골드3](https://github.com/youngpark17/Algo/commit/a463eff5b6806d5c8dd9ee816c0c3bc4fcc079a1)
시뮬레이션


[백준 2146 다리만들기 골드4](https://github.com/youngpark17/Algo/commit/073ce595b13f35daf2762bbfcb481b86dbd5b12d)
bfs, dfs

[백준 17136 색종이 붙이기 골드3](https://github.com/youngpark17/Algo/commit/1c77ade61c8328b07d11e278c00c7f88bed7e776)
백트래킹과 그리디.

[백준 2752 보이는 점의 개수 실버2](https://github.com/youngpark17/Algo/commit/023998ac8163cfa7e3b522ce235495fd41985f95)
테스트 케이스가 여러개 들어오므로 메모리제이션 활용하면 되는 것을...

[백준 2636 치즈 골드5](https://github.com/youngpark17/Algo/commit/46fb66daeba763bbc90ca5ff441ff5ffbe2c352e)
항상 비어있는 칸 기준으로 bfs 돌리면 된다... 디버깅 안될땐 그냥 다시 풀자...

[백준 4149 큰 수 소인수 분해 플레2](https://github.com/youngpark17/Algo/commit/b5d0fd4709cfdaddf34c8af75cc91b2cfddf88ff)
이게 플레2인데 내가 맞은걸 보면 테스트케이스 빈약한듯...?
에라토스테네스의 체...아... 158개중 30개만 맞음...
[백준 13460 구슬탈출2 골드3 백트래킹+시뮬레이션](https://github.com/youngpark17/Algo/commit/77f82c6042748cc53cc16e21c32c3ba8bc511075)
static으로 설정한 변수를 파라미터로 바꾸면 되는 것을....

[백준 2206 벽 부수고 이동하기 골드4 bfs](https://github.com/youngpark17/Algo/commit/8682e2db5357f8fe53a8da063af454828f475073)

[백준 1080 행렬 실버 2 그리디](https://github.com/youngpark17/Algo/commit/1baee55ec5a52bbc4732308a565db3063e815a10)

[백준 1248 골드 3 백트래킹](https://github.com/youngpark17/Algo/commit/1fe7dbfe660011a1d86f3463d8d9184b0dc53dc6)

백준 1339

백준 2003

백준 2042

백준 2609

백준 2805

백준 1010

백준 1062

백준 1260

백준 1339

백준 1655

백준 1713

백준 1717

백준 1735

백준 1753

백준 1806

백준 1837

백준 1922

백준 1927

백준 2146

백준 2178

백준 2438

백준 2748

백준 2824

백준 2839

백준 2960

백준 3055

백준 3190

백준 4358

백준 4963

백준 5376

백준 5568

백준 5639

백준 6588

백준 9663

백준 10610

백준 10828

백준 10989

백준 11050

백준 11051

백준 11437

백준 12100

백준 13251

백준 13458

백준 13460

백준 14476

백준 14499

백준 14500

백준 14501

백준 14502

백준 14503

백준 14888

백준 14889

백준 14891

백준 15649

백준 15650

백준 15651

백준 15652

백준 15654

백준 15655

백준 15656

백준 15657

백준 15663

백준 15664

백준 15665

백준 15666

백준 15683

백준 15684

백준 15685

백준 16234

백준 16235

백준 16236

백준 16637

백준 17135

백준 17140

백준 17142

백준 17281

백준 17406

백준 17471

백준 17472

백준 17779

백준 17822

백준 17836
