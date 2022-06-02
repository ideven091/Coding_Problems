
function isSafe(grid,row,col,n,position){
    for (let i = 0; i < n; i++) {
        if(grid[row][i]===position)
            return false;
        if(grid[i][col]===position)
            return false;
    }
    //Checking in the sudoku square
    const boxLength = math.sqrt(n);
    const rowSize = row - row%boxLength;
    const colSize = col - col%boxLength;

    for(let i=0;i<rowSize;i++){
        for (let j = 0; j < colSize; j++) {
            if(grid[boxLength+rowSize][boxLength+colSize]===position)
                return false;
        }
    }
    return true;

}

function sudokuSolver(grid){
    const n = grid.length;
    let row=-1,col=-1,flag=false;
    for(let i=0;i<n;i++){
        for(let j=0;j<n;j++){
            if(grid[i][j]===0){
                flag = true;
                break;
            }
            if(!flag)
                break;


        }

    }
    if(flag)
        return true;

    for(let i=1;i<=n;i++){
        grid[row][col]=i;
        if(isSafe(grid,row,col,n,i)) {
            if (sudokuSolver(grid))
                return true;
            else
                grid[row][col] = 0;
        }
    }

}