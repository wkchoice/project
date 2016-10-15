/*
서버 : 포트를 열고 대기한 상태에서 클라이언트가 접속하면 Hello World를 전송
클라이언트 : 서버의 IP와 PORT번호를 입력하여 서버에 접근하자마자 Read하고 받은 데이터를 출력

서버와 클라이언트 프로젝트를 각각 만들어야함
프로젝트에 라이브러리 추가-> 프로젝트 오른쪽 클릭 -> 속성 -> 링커 -> 입력으로 이동 -> 추가 종속성 -> 편집 누르기 -> ws2_32.lib 를 적기


서버,클라이언트 둘다 실행시 main 에 매개변수를 줘야 실행이 됨

Cmd를 이용한 main문에 매개변수 전달 (프로젝트 빌드 후)
서버
실행 파일 + 포트번호 매개변수 입력

클라이언트 (출력결과)
IP번호 (현재는 같은 컴퓨터에서 실행해서 로컬호스트인 127.0.0.1 입력)와 서버에서 연 PORT번호 입력
*/


#include <stdio.h>
#include <stdlib.h>
#include <winsock2.h>
void ErrorHandling(char* message);

int main(int argc, char* argv[])
{
	WSADATA    wsaData;
	SOCKET hServSock, hClntSock;
	SOCKADDR_IN servAddr, clntAddr;

	int szClntAddr;
	char message[] = "Hello World!";

	if (argc != 2)
	{
		printf("Usage : %s <port>\n", argv[0]);
		exit(1);
	}

	if (WSAStartup(MAKEWORD(2, 2), &wsaData) != 0)
		ErrorHandling("WSAStartup() error!");

	hServSock = socket(PF_INET, SOCK_STREAM, 0);
	if (hServSock == INVALID_SOCKET)
		ErrorHandling("socket() error");

	memset(&servAddr, 0, sizeof(servAddr));
	servAddr.sin_family = AF_INET;
	servAddr.sin_addr.s_addr = htonl(INADDR_ANY);
	servAddr.sin_port = htons(atoi(argv[1]));

	if (bind(hServSock, (SOCKADDR*)&servAddr, sizeof(servAddr)) == SOCKET_ERROR)
		ErrorHandling("bind() error");

	if (listen(hServSock, 5) == SOCKET_ERROR)
		ErrorHandling("listen() error");

	szClntAddr = sizeof(clntAddr);
	hClntSock = accept(hServSock, (SOCKADDR*)&clntAddr, &szClntAddr);
	if (hClntSock == INVALID_SOCKET)
		ErrorHandling("accept() error");

	send(hClntSock, message, sizeof(message), 0);
	closesocket(hClntSock);
	closesocket(hServSock);
	WSACleanup();
	return 0;
}

void ErrorHandling(char* message)
{
	fputs(message, stderr);
	fputc('\n', stderr);
	exit(1);
}

