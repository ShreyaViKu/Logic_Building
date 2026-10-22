class Arithematic
{
    constructor(a,b)
    {
        this.no1 = a;
        this.no2 = b;
    }

    Addition()
    {
        return this.no1+this.no2;
    }

    Subtraction()
    {
        return this.no1-this.no2;
    }
}
function main()
{
    let aobj = new Arithematic(3,2);

    console.log(aobj.Addition());

    console.log(aobj.Subtraction());

}

main();