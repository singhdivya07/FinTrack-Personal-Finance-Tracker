import axios from 'axios';

export const getHealthStatus = async () => {
    try {
        const res = await axios.get('/api/health');
        return res.data;
    } catch (err) {
        console.log("backend not reachable ", err);
        throw err;
    }
};