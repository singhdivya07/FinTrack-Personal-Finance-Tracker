import { useEffect, useState } from 'react';
import { getHealthStatus } from './api/healthApi';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
    const [status, setStatus] = useState<string>('Loading...');
    const [isError, setIsError] = useState(false);

    useEffect(() => {
        getHealthStatus()
            .then((data) => setStatus(JSON.stringify(data, null, 2)))
            .catch(() => {
                setIsError(true);
                setStatus('Failed to connect to backend');
            });
    }, []);

    return (
        <div className="container vh-100 d-flex justify-content-center align-items-center bg-light">
            <div className="card shadow-lg p-4" style={{ width: '28rem' }}>
                <h2 className="text-center mb-3 fw-bold text-primary">
                    FinTrack Health Check
                </h2>
                <pre
                    className={`border rounded p-3 ${
                        isError ? 'bg-danger-subtle text-danger' : 'bg-success-subtle text-success'
                    }`}
                >
          {status}
        </pre>
                <div className="text-center mt-3 text-muted small">
                    <i>Backend → http://localhost:8080/api/health</i>
                </div>
            </div>
        </div>
    );
}

export default App;
