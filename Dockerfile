FROM python:3.10-slim AS base

# Set environment variables
ENV PYTHONDONTWRITEBYTECODE=1
ENV PYTHONUNBUFFERED=1

# Install Python dependencies
RUN pip install --upgrade pip
#   Move into correct directory
WORKDIR /app
COPY server/requirements.txt .
RUN pip install -r requirements.txt

# Copy application code
COPY server/ .

# Expose Flask's default port
EXPOSE 5000

# Command to start Flask server
CMD ["python", "api.py"]