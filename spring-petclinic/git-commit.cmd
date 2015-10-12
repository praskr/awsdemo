git status
git add --all
git status
set /p commitComment=Enter the Commit Comment:%=%
git commit -m "%commitComment%"
git status
git push origin master
sudo git push --repo https://praskr:test1234@github.com/praskr/awsdemo.git