@echo off
rem 명령어 복창 끔

rem ### 버전정보	:	v1.0.0
rem ### updated by LJS 

rem chcp 65001>nul
rem 참고 https://otrodevym.tistory.com/entry/windows-10-cmd-%EC%9D%B8%EC%BD%94%EB%94%A9-utf-8-%EC%84%A4%EC%A0%95-%EB%B0%A9%EB%B2%95-949-65001-1

setLocal EnableDelayedExpansion
rem 참고 https://kkamagistory.tistory.com/881

rem 0 = 검정색 8 = 회색
rem 1 = 파랑색 9 = 연한 파랑색
rem 2 = 초록색 A = 연한 초록색
rem 3 = 옥색 B = 연한 옥색
rem 4 = 빨강색 C = 연한 빨강색
rem 5 = 자주색 D = 연한 자주색
rem 6 = 노랑색 E = 연한 노랑색
rem 7 = 흰색 F = 밝은 흰색
rem color 09
rem 첫째 자리는 배경, 둘째 자리는 글자색

rem mode con cols=60 lines=30
rem 콘솔창 크기 지정

rem ####################################

cd /d %~dp0
rem 현재 파일 위치 경로를 작업 위치로

rem title 현재 경로 : %cd%
title 섯다.bat

:notice
rem echo 	## 업데이트 내역 ##

:start
rem echo 		플레이어 이름
set /p playerNickName=플레이어 이름 입력:
set playerRank=호구
set /a playerAddToBoard=1000
set /a playerBalance=-1000
set playerDeck=끗
set /a playerRandom=1

set /p computerNickName=상대방 이름 입력:
set computerRank=호구
set /a computerAddToBoard=1000
set /a computerBalance=-1000
set computerDeck=끗
set /a computerRandom=1

set /a boardMoney=2000

echo 	시작 판돈은 %boardMoney%원입니다.
pause
:choiceBattle
cls
echo.
echo 	[%playerRank%]%playerNickName% 자산: %playerBalance%
echo 	[%computerRank%]%computerNickName% 자산: %computerBalance%
echo 	###1. 대결하기
echo 	###2. 나가기
echo.
set /p choiceBattle=선택:
if %choiceBattle% equ 1 goto getCard
if %choiceBattle% equ 2 exit
echo.
echo 	잘못된 입력입니다.
echo 	대결하기로 돌아갑니다.
pause
cls
goto choiceBattle

:battle
cls
echo. 	
echo 	###나의 덱: %playerDeck%
echo 	###1.판돈 키우기
echo 	###2.그대로 진행하기
set /p choice=입력:
if %choice% equ 1 goto addBoardMoney
if %choice% equ 2 goto checkBattle

:addBoardMoney
echo.
echo 	###추가할 금액 입력(1000단위)
set /p add=입력:
set /a boardMoney=%boardMoney%+%add%
goto checkBattle

:getCard
set /a playerRandom=%random% %% 3 + 1
if %playerRandom% equ 1 set playerDeck=끗
if %playerRandom% equ 2 set playerDeck=땡
if %playerRandom% equ 3 set playerDeck=광땡

set /a computerRandom=%random% %% 3 + 1
if %playerRandom% equ 1 set computerDeck=끗
if %playerRandom% equ 2 set computerDeck=땡
if %playerRandom% equ 3 set computerDeck=광땡
goto battle

:checkBattle
if %playerRandom% equ %computerRandom% goto draw
if %playerRandom% lss %computerRandom% goto lose
if %playerRandom% gtr %computerRandom% goto win
echo checkbattle 이상함
pause

:draw
rem 무승부인 경우
cls
echo 	[무승부]

set /a playerBalance=%playerBalance%-%boardMoney%
set /a playerBalance=%computerBalance%-%boardMoney%
set /a boardMoney=%boardMoney%+%boardMoney%*2
echo 	고 혹은 다이를 진행합니다.
pause
cls
goto goOrStop

:lose
rem 플레이어가 진 경우
cls
echo 	[패배]
echo 	기존자산: %playerBalance%
set /a playerBalance=%playerBalance%-(%boardMoney%-%playerAddToBoard%)
set /a computerBalance=%computerBalance%+(%boardMoney%-%computerAddToBoard%)
echo 	현재자산: %playerBalance%

pause
cls
goto choiceBattle

:win
rem 플레이어가 이긴 경우
cls
echo 	[승리]
echo 	기존자산: %playerBalance%
set /a playerBalance=%playerBalance%+(%boardMoney%-%playerAddToBoard%)
set /a computerBalance=%computerBalance%-(%boardMoney%-%computerAddToBoard%)
echo 	현재 자산: %playerBalance%
pause
cls
goto choiceBattle

:goOrStop
cls
echo 		현재 판돈: %boardMoney%
echo 	###나의 패: %playerDeck%
echo 	###1.고 2.다이
set /p choice="입력: "
if choice equ 1 goto checkBattle
if choice equ 2 goto lose

pause
cls
goto choiceBattle