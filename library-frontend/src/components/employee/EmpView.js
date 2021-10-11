import { useEffect } from "react"

const EmpView = () => {
    let books = [{id:1, title:"Narnia", author:"Joe", date:1999},
     {id:2, title:"Narniant", author:"Joeseph", date:1998}]
    
    //useEffect to load all books when the page is loaded
    useEffect(()=> {
        getBooks();
        populateTable();
    })

    //get books from server
    const getBooks = async () => {
        console.log(books);
    }

    //populate table with book data
    let populateTable = ()=> {
        console.log("Called populateTable");
        return books.map((book, index)=> {
            return (
                <tr key={book.id}>
                    <td>{book.title}</td>
                    <td>{book.author}</td>
                    <td>{book.date}</td>
                </tr>
            )
        })
    }

    return (
        <div>
            <hr/>
            <h1>Welcome to the Employee View</h1>
            <div className="addBook">
                    <h2>Add a new book</h2>
                    <form>
                        <label className="addLabel">Title: <input type="text" name="title" className="addInput"></input></label><br/>
                        <label className="addLabel">Author: <input type="text" name="author"className="addInput"></input></label><br/>
                        <label className="addLabel">Date: <input type="date" name="date"className="addInput"></input></label><br/>
                        <input type="submit" value="Add Book"/>
                        <input type="reset"/>
                    </form>
            </div>
            <br/>
            <h2>Search existing books</h2>
            <p>(Leave empty to display all books)</p>
            <form>
                <input type="text" name="userQuery"></input>
                <input type="submit" value="Search"/>
                    <label><input defaultChecked type="radio" name="search" value="Author"/>Author</label>
                    <label><input type="radio" name="search" value="Title"/>Title</label>
            </form>
            <br/>
            <table border={1} className="table">
                    <thead>
                        <tr key='head'>
                            <th>Title</th>
                            <th>Author</th>
                            <th>Date Released</th>
                        </tr>
                    </thead>
                    <tbody>
                        {populateTable()}
                    </tbody>
                </table>
                
        </div>
    )
}

export default EmpView
