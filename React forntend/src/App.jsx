import ClockHeading from './ClockHeading';
import Slogan from './ClockSlowgun';
import CurrentTime from './CurrentTime';
import './App.css'

function App() {
  return <center className='container'>
    <ClockHeading></ClockHeading>
    <Slogan></Slogan>
    <CurrentTime></CurrentTime>
  </center>
}

export default App;