//credit http://www.usaco.org/current/data/sol_ballet.html
#include <fstream>
#include <algorithm>

using namespace std;

const int d[4][2]={{-1,0},{0,1},{1,0},{0,-1}}; 	// (dy,dx)
{0:forward,1:right,2:back,3:left}
struct Point { int y,x; }
	foot[4]={{0,0},{0,1},{1,0},{1,1}};	// initial feet positions
int dir;					// {0:north,1:west,2:south,3:east}
int miny,minx,maxy,maxx;			// min - max coordinates of the area

int move(string s)
{
	// determine the foot
	int f=0;
	if (s[0]=='F' && s[1]=='R') f=1;
	else if (s[0]=='R')
		if (s[1]=='L') f=2;
		else f=3;

	// clockwise rotation
	if (s[2]=='P')
	{
		for (int i=0; i<4; i++)
		{
			int ny=foot[f].y+foot[i].x-foot[f].x;
			int nx=foot[f].x+foot[f].y-foot[i].y;
			foot[i].y=ny,foot[i].x=nx;
		}
		dir=(dir+1)%4;		// rotate direction clockwise
	}
	// move
	else
	{
		// get the relative direction
		int m=0;
		if (s[2]=='R') m=1;
		if (s[2]=='B') m=2;
		if (s[2]=='L') m=3;
		m=(m+dir)%4;		// calculate the absolute direction

		foot[f].y+=d[m][0];
		foot[f].x+=d[m][1];

		// check if Bessie trips
		for (int i=0; i<4; i++)
			if (f!=i && foot[f].y==foot[i].y && foot[f].x==foot[i].x)
				return 0;
	}

	// update minimum size rectangle
	for (int i=0; i<4; i++)
	{
		if (miny>foot[i].y) miny=foot[i].y;
		if (maxy<foot[i].y) maxy=foot[i].y;
		if (minx>foot[i].x) minx=foot[i].x;
		if (maxx<foot[i].x) maxx=foot[i].x;
	}
	return 1;
}

int main()
{
	ifstream fin("ballet.in");
	ofstream fout("ballet.out");

	int n,valid=1;
	fin >> n;
	string inst;
	for (int i=0; i<n; i++)
	{
		fin >> inst;
		if (!(valid=move(inst))) break;
	}

	if (valid)
		fout << (maxy-miny+1)*(maxx-minx+1) << endl;
	else
		fout << -1 << endl;

	fin.close();
	fout.close();
}