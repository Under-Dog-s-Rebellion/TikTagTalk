import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {BrowserRouter} from 'react-router-dom'
import {Provider} from 'react-redux'
import store from './redux/store';
import axios from 'axios';
import GlobalStyle from './GlobalStyle';
import { PersistGate } from 'redux-persist/integration/react';
import { persistStore} from 'redux-persist';
import { CookiesProvider } from 'react-cookie';


let persistor = persistStore(store);
const root = ReactDOM.createRoot(document.getElementById('root'));
axios.defaults.withCredentials = true;

root.render(
  // <React.StrictMode>
    <Provider store={store}>
      <GlobalStyle />
      <PersistGate loading={null} persistor={persistor}>
        <CookiesProvider>
          <BrowserRouter>
            <App />
          </BrowserRouter>
        </CookiesProvider>
      </PersistGate>
    </Provider>
  // </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
