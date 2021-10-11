//convention for components is to start with a capital letter
import PropTypes from 'prop-types'
import Button from './Button'

const headingStyle = {
    color:'darkRed',
    backgroundColor: 'lightgrey'
}

const Header = ({name}) => {
    const myClick = () => {
        console.log("click");
    }

    return (
        <header>
            <h1 style={headingStyle}>
                Hello from {name}
            </h1>
            <Button color='green' text='Add' onClick={myClick}/>
            <br/>
        </header>
    )
}

Header.defaultPropts = {
    name: 'Joshua',
}

Header.propTypes = {
    name: PropTypes.string,
}

export default Header
