# RoadSimulator

이 프로그램은 한 구역을 이동할 때의 이동 거리를 계산하기 위한 프로그램입니다.

소스 코드 내 reset() 함수의 값들을 수정해 커스텀이 가능합니다.
LENGTH: 한 Unit의 길이입니다.
xUNIT: x축으로의 Unit의 수입니다.
yUNIT: y축으로의 Unit의 수입니다.
나머지 값들은 수정하지 마세요.

해당 값들을 변경한 후에는 setup()의 size() 함수의 파라미터를 옆에 적힌 주석대로 수정해주세요.

[조작키]
DownArrow: 아래로 1 Unit 이동합니다.
RightArrow: 오른쪽으로 1 Unit 이동합니다.
Shift: 대각선/직선 모드를 변경합니다. 좌측 상단 색으로 표시합니다.(Red:직선/Blue:대각선)
(모드는 아래에서 다시 서술합니다.)
Enter/Return: 초기화합니다.

[모드]
직선 모드(Red):
- 이 모드에선 직선 및 직각으로 움직인다고 설정합니다.  움직일 때마다 Distance에 LENGTH만큼 가산됩니다.

대각선 모드(Blue): 
- 이 모드에선 대각선으로 움직일 벡터값을 설정합니다. 
- 방향키로 움직인 후 다시 Shift를 누르면, 파란 선이 시작된 지점부터 끝 지점까지 대각선으로 이어질 것입니다.
- 이때의 대각선의 길이만큼 Distance에 가산됩니다.

(*) Distance 값은 float로 정의되어 있습니다.


Changelog

[2019.01.12.]
* RoadSimulator_v1 완성
* RoadSimulator_v2 개발 중
+ UNIT이  xUNIT, yUNIT으로 나누어짐

