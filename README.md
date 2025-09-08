# search-advisory

## Backend Setup

### Database Configuration

The backend is configured to use MySQL as the database. Make sure you have MySQL installed and running.

#### Default Configuration
- Database: `search_advisory` (will be created automatically)
- Host: `localhost:3306`
- Username: `root`
- Password: `password`

#### Setup Steps
1. Install MySQL if not already installed
2. Start MySQL service
3. The application will automatically create the database `search_advisory` on first run
4. Update the database credentials in `backend/src/main/resources/application.properties` if needed

#### Running the Backend
```bash
cd backend
mvn spring-boot:run
```