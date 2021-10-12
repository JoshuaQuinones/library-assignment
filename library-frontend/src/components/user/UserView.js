import { useEffect } from "react";
import { useState } from "react";

const UserView = () => {
    const [books, updateBooks] = useState([])
    
    //useEffect to load all books when the page is loaded
    useEffect(()=> {
        getBooks();
        console.log("useEffect Called")
    }, [])

    //get books from server
    const getBooks = async () => {
        const response = await fetch('http://localhost:8080/getBooks', {
            method:'GET'
        })
        const data = await response.json();
        updateBooks(data);
    }

    //populate table with book data
    let populateTable = ()=> {
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

//Functions for searching

    //get books from server according to author or title, based on user input
    const getBookQuery = async (query, searchByTitle) => {
        //if searchByTitle true, search by title
        if (searchByTitle) {
            let fullQuery = 'http://localhost:8080/getBooksTitle/' + query
            console.log(fullQuery);
            const response = await fetch(fullQuery, {
            method:'GET'
            })
            const data = await response.json();
            updateBooks(data);
        }
        //else, search by author
        else {
            let fullQuery = 'http://localhost:8080/getBooksAuthor/' + query
            console.log(fullQuery);
            const response = await fetch(fullQuery, {
            method:'GET'
            })
            const data = await response.json();
            updateBooks(data);
        }
    }

    //form value for search
    const [query, setQuery] = useState('');
    const [queryType, setQueryType] = useState('');
    
    //call function when submitting form to search
    let submitFuncSearch = (event) => {
        event.preventDefault();
        //if empty, just call getBooks()
        if (!query) {
            getBooks();
            return;
        }
        else {
            //determine if search is by author or title
            if (queryType === "Title") {
                getBookQuery(query, true)
            }
            else {
                getBookQuery(query, false)
            }
            setQuery('');
        }
    }

    const onRadioChange = (event)=> {
        setQueryType(event.target.value);
    }


    return (
        <div>
            <hr/>
            <h1>Welcome to the User View</h1>
            <form onSubmit={submitFuncSearch}> 
                <input type="text" name="userQuery" value={query} onChange={(e) => setQuery(e.target.value)}></input>
                <input type="submit" value="Search"/>
                <div onChange={onRadioChange} style={{display:"inline-block"}}>
                    <label><input defaultChecked type="radio" name="search" value="Author"/>Author</label>
                    <label><input type="radio" name="search" value="Title"/>Title</label>
                </div>
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

export default UserView
