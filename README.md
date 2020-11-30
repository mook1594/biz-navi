# navi

### 목표
- 시작, 이동 과정 데이터, 종료 데이터를 수신 후 유효한 정보인지 판단

### 요구사항
- 내비 종료시 사용자의 위치에 따라 업무 인정과 불인정으로 나눠 저장
- 수신되는 데이터별 조건
  #### <내비 시작>
  - 설정된 목적지와 내비 종료 위치가 100m 이내이면 업무인정 종료. 그외엔 불인정 처리.

  #### <사용자의 현재 위치 정보와 남은 거리>
  - 1초에 한번씩 위치정보가 수신
  - GPS의 이동거리가 500m 이내인 경우엔 결과 테이블에 저장하지 않음.
  - 1시간 동안 위치가 변경 되지 않으면 결과를 저장하지 않음.
  - 내비 시작 후 24시간 동안 위치 정보가 수신 되지 않으면 저장하지 않음.
  - 종료 후에 위치 정보가 업데이트 되는 경우 무시

  #### <내비 종료>
  - 유효한 정보인지 판단 
  - 결과 저장 데이터 [transactionId, 출발일시, 도착일시, 출발지, 도착지, 주행거리, 위도, 경도]

### 조건
- 동시 1000명의 사용자가 사용할 수 있는 시스템 설계

### 샘플데이터 
##### 1. 업무 인정 종료
``` json
{
 "type": "StartNavi",
 "location": {
 "transId": "kakao20201113-0001",
 "dateTime": "202011131101020003",
 "totalDistance": 7000,
 "startName": "성남시청",
 "goalName": "카카오모빌리티",
 "lng": 127.567849497291,
 "lat": 36.957739187083654
 }
}
{
 "type": "UpdateLocation",
 "location": {
 "transId": "kakao20201113-0001",
 "dateTime": "202011131101020004",
 "remainDistance": 6900,
 "lng": 127.5678494971,
 "lat": 36.9577391883654
 }
}
{
 "type": "UpdateLocation",
 "location": {
 "transId": "kakao20201113-0001",
 "dateTime": "202011131101020005",
 "remainDistance": 200,
 "lng": 127.5678494971,
 "lat": 36.9577391883654
 }
}
{
 "type": "UpdateLocation",
 "location": {
 "transId": "kakao20201113-0001",
 "dateTime": "202011131101020006",
 "remainDistance": 50,
 "lng": 127.5678494971,
 "lat": 36.9577391883654
 }
}
{
 "type": "Close",
 "location": {
 "transId": "kakao20201113-0001",
 "dateTime": "202011131101020006",
 "remainDistance": 20,
 "lng": 127.5678494971,
 "lat": 36.9577391883654
 }
}

```
##### 2. 업무 불인정 종료
``` json
{
 "type": "StartNavi",
 "location": {
 "transId": "kakao20201113-0001",
 "dateTime": "202011131101020003",
 "totalDistance": 7000,
 "startName": "성남시청",
 "goalName": "카카오모빌리티",
 "lng": 127.567849497291,
 "lat": 36.957739187083654
 }
}
{
 "type": "UpdateLocation",
 "location": {
 "transId": "kakao20201113-0001",
 "dateTime": "202011131101020004",
 "remainDistance": 6900,
 "lng": 127.5678494971,
 "lat": 36.9577391883654
 }
}
{
 "type": "UpdateLocation",
 "location": {
 "transId": "kakao20201113-0001",
 "dateTime": "202011131101020005",
 "remainDistance": 600,
 "lng": 127.5678494971,
 "lat": 36.9577391883654
 }
}
{
 "type": "UpdateLocation",
 "location": {
 "transId": "kakao20201113-0001",
 "dateTime": "202011131101020006",
 "remainDistance": 550,
 "lng": 127.5678494971,
 "lat": 36.9577391883654
 }
}
{
 "type": "Close",
 "location": {
 "transId": "kakao20201113-0001",
 "dateTime": "202011131101020006",
 "remainDistance": 520,
 "lng": 127.5678494971,
 "lat": 36.9577391883654
 }
}

```
##### 3. 결과 저장 안함
``` json
{
 "type": "StartNavi",
 "location": {
 "transId": "kakao20201113-0002",
 "dateTime": "202011131101020003",
 "totalDistance": 7000,
 "startName": "성남시청",
 "goalName": "카카오모빌리티",
 "lng": 127.567849497291,
 "lat": 36.957739187083654
 }
}
{
 "type": "UpdateLocation",
 "location": {
 "transId": "kakao20201113-0002",
 "dateTime": "202011131101020004",
 "remainDistance": 6900,
 "lng": 127.5678494971,
 "lat": 36.9577391883654
 }
}
{
 "type": "Close",
 "location": {
 "transId": "kakao20201113-0002",
 "dateTime": "202011131101020005",
 "remainDistance": 6600,
 "lng": 127.5678494971,
 "lat": 36.9577391883654
 }
}
```
