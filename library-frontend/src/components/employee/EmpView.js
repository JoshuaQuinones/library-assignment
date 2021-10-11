import { useEffect } from "react"

const EmpView = () => {
    let dummy = [{id:1, name:"Narnia", author:"Joe", released:1999}]
    
    //useEffect to load all books when the page is loaded
    useEffect(()=> {
        const getBooks = async () => {
            console.log(dummy);
        }

        getBooks();
    })
    
    return (
        <div>
            <h1>Welcome to Employee View</h1>
            <form>
                <input type="text"></input>
            </form>
        </div>
    )
}

export default EmpView
