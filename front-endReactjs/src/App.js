import HomePage from './page/HomePage'
import SearchPage from './page/SearchPage'
import { Routes ,Route} from 'react-router-dom';

function App() {
  return (
    <div >
      <Routes>
          <Route path="/" element={<HomePage/>}/>
          <Route path="/search" element={<SearchPage/>}/>
      </Routes>
    </div>
  );
}

export default App;
