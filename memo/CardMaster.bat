@echo off
rem ��ɾ� ��â ��

rem ### ��������	:	v1.0.0
rem ### updated by LJS 

rem chcp 65001>nul
rem ���� https://otrodevym.tistory.com/entry/windows-10-cmd-%EC%9D%B8%EC%BD%94%EB%94%A9-utf-8-%EC%84%A4%EC%A0%95-%EB%B0%A9%EB%B2%95-949-65001-1

setLocal EnableDelayedExpansion
rem ���� https://kkamagistory.tistory.com/881

rem 0 = ������ 8 = ȸ��
rem 1 = �Ķ��� 9 = ���� �Ķ���
rem 2 = �ʷϻ� A = ���� �ʷϻ�
rem 3 = ���� B = ���� ����
rem 4 = ������ C = ���� ������
rem 5 = ���ֻ� D = ���� ���ֻ�
rem 6 = ����� E = ���� �����
rem 7 = ��� F = ���� ���
rem color 09
rem ù° �ڸ��� ���, ��° �ڸ��� ���ڻ�

rem mode con cols=60 lines=30
rem �ܼ�â ũ�� ����

rem ####################################

cd /d %~dp0
rem ���� ���� ��ġ ��θ� �۾� ��ġ��

rem title ���� ��� : %cd%
title ����.bat

:notice
rem echo 	## ������Ʈ ���� ##

:start
rem echo 		�÷��̾� �̸�
set /p playerNickName=�÷��̾� �̸� �Է�:
set playerRank=ȣ��
set /a playerAddToBoard=1000
set /a playerBalance=-1000
set playerDeck=��
set /a playerRandom=1

set /p computerNickName=���� �̸� �Է�:
set computerRank=ȣ��
set /a computerAddToBoard=1000
set /a computerBalance=-1000
set computerDeck=��
set /a computerRandom=1

set /a boardMoney=2000

echo 	���� �ǵ��� %boardMoney%���Դϴ�.
pause
:choiceBattle
cls
echo.
echo 	[%playerRank%]%playerNickName% �ڻ�: %playerBalance%
echo 	[%computerRank%]%computerNickName% �ڻ�: %computerBalance%
echo 	###1. ����ϱ�
echo 	###2. ������
echo.
set /p choiceBattle=����:
if %choiceBattle% equ 1 goto getCard
if %choiceBattle% equ 2 exit
echo.
echo 	�߸��� �Է��Դϴ�.
echo 	����ϱ�� ���ư��ϴ�.
pause
cls
goto choiceBattle

:battle
cls
echo. 	
echo 	###���� ��: %playerDeck%
echo 	###1.�ǵ� Ű���
echo 	###2.�״�� �����ϱ�
set /p choice=�Է�:
if %choice% equ 1 goto addBoardMoney
if %choice% equ 2 goto checkBattle

:addBoardMoney
echo.
echo 	###�߰��� �ݾ� �Է�(1000����)
set /p add=�Է�:
set /a boardMoney=%boardMoney%+%add%
goto checkBattle

:getCard
set /a playerRandom=%random% %% 3 + 1
if %playerRandom% equ 1 set playerDeck=��
if %playerRandom% equ 2 set playerDeck=��
if %playerRandom% equ 3 set playerDeck=����

set /a computerRandom=%random% %% 3 + 1
if %playerRandom% equ 1 set computerDeck=��
if %playerRandom% equ 2 set computerDeck=��
if %playerRandom% equ 3 set computerDeck=����
goto battle

:checkBattle
if %playerRandom% equ %computerRandom% goto draw
if %playerRandom% lss %computerRandom% goto lose
if %playerRandom% gtr %computerRandom% goto win
echo checkbattle �̻���
pause

:draw
rem ���º��� ���
cls
echo 	[���º�]

set /a playerBalance=%playerBalance%-%boardMoney%
set /a playerBalance=%computerBalance%-%boardMoney%
set /a boardMoney=%boardMoney%+%boardMoney%*2
echo 	�� Ȥ�� ���̸� �����մϴ�.
pause
cls
goto goOrStop

:lose
rem �÷��̾ �� ���
cls
echo 	[�й�]
echo 	�����ڻ�: %playerBalance%
set /a playerBalance=%playerBalance%-(%boardMoney%-%playerAddToBoard%)
set /a computerBalance=%computerBalance%+(%boardMoney%-%computerAddToBoard%)
echo 	�����ڻ�: %playerBalance%

pause
cls
goto choiceBattle

:win
rem �÷��̾ �̱� ���
cls
echo 	[�¸�]
echo 	�����ڻ�: %playerBalance%
set /a playerBalance=%playerBalance%+(%boardMoney%-%playerAddToBoard%)
set /a computerBalance=%computerBalance%-(%boardMoney%-%computerAddToBoard%)
echo 	���� �ڻ�: %playerBalance%
pause
cls
goto choiceBattle

:goOrStop
cls
echo 		���� �ǵ�: %boardMoney%
echo 	###���� ��: %playerDeck%
echo 	###1.�� 2.����
set /p choice="�Է�: "
if choice equ 1 goto checkBattle
if choice equ 2 goto lose

pause
cls
goto choiceBattle